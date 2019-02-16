package sheets;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import util.MapDB;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by alexwyler on 2/14/19.
 */
public class SheetsApi {
    private static final String      APPLICATION_NAME      = "RKT Droptimizer";
    private static final JsonFactory JSON_FACTORY          = JacksonFactory.getDefaultInstance();
    private static final String      TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES                = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String       CREDENTIALS_FILE_PATH = "/sheets-credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) {
        // Load client secrets.
        InputStream in = SheetsApi.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        try {
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                    .setAccessType("offline")
                    .build();
            LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
            return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Spreadsheet createNewSpreadsheet() throws IOException, GeneralSecurityException {
        Spreadsheet requestBody = new Spreadsheet();
        Sheets.Spreadsheets.Create request = getService().spreadsheets().create(requestBody);

        return request.execute();
    }

    public static Sheets getService() {
        final NetHttpTransport HTTP_TRANSPORT;
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }

        Sheets sheetsService = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        return  sheetsService;
    }

    public static Spreadsheet getOrCreateSpreadsheetFromDB() {
        Map<String, String> dataMap = MapDB.getDataMap();
        Spreadsheet         spreadsheet;
            String                        spreadsheetId = dataMap.get("spreadsheetId");
            try {
                if (spreadsheetId == null) {
                    spreadsheet = createNewSpreadsheet();
                    dataMap.put("spreadsheetId", spreadsheet.getSpreadsheetId());
                } else {
                    spreadsheet = readFromExistingSheet(spreadsheetId);
                }
            } catch (IOException | GeneralSecurityException e) {
                throw new RuntimeException(e);
            }

        return spreadsheet;
    }


    public static Spreadsheet readFromExistingSheet(String spreadsheetId) throws IOException, GeneralSecurityException {

        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        Sheets sheetsService = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        Sheets.Spreadsheets.Get request = sheetsService.spreadsheets().get(spreadsheetId);

        return request.execute();

    }
}
