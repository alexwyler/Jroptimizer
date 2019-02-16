import battlenet.BattleNetApi;
import battlenet.objects.SGuild;
import com.google.api.services.sheets.v4.model.*;
import raidbots.RaidBotsAPI;
import raidbots.objects.SInstance;
import raidbots.objects.SItem;
import sheets.SheetsApi;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by alexwyler on 2/15/19.
 */
public class Main {

    /*
     * NOTE: this is a hack because all the RKT officers are the same rank as their alts so we can't include the officer
     * rank without a bunch of garbage.  Instead, we'll whitelist the officers and include the Raider rank
     */
    private static List<String> RKT_OFFICER_WHITELIST = Arrays.asList("Fortch", "Emeraldchi", "Meds");

    public static void main(String args[]) throws IOException, ExecutionException, InterruptedException {

        SGuild                        guild   = BattleNetApi.getGuildMembers("Lightbringer", "Resident Kabuki Theatre");
        List<SGuild.SMemberCharacter> raiders = guild.members.stream().filter(m -> {
            if (m.rank == 1) {
                if (!RKT_OFFICER_WHITELIST.contains(m.character.name)) {
                    return false;
                }
            }
            return Arrays.asList(0l, 1l, 4l).contains(m.rank) && m.character.level == 120l;
        }).map(m -> m.character).collect(Collectors.toList());

        SInstance instance = SInstance.getInstanceForName("Battle of Dazar'alor");
        List<Object> encounterNames = instance.encounters.stream().map(e -> e.name).collect(Collectors.toList());
        int numEncounters = encounterNames.size();

        Spreadsheet spreadsheet = SheetsApi.getOrCreateSpreadsheetFromDB();
        Sheet sheet1 = spreadsheet.getSheets().get(0);

        List<List<Object>> values = Arrays.asList(
                encounterNames
        );

        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result =
                SheetsApi.getService().spreadsheets().values().update(spreadsheet.getSpreadsheetId(), "B1:J1", body)
                        .setValueInputOption("USER_ENTERED")
                        .execute();

        BatchUpdateSpreadsheetRequest batchReq = new BatchUpdateSpreadsheetRequest();
        List<Request> requests = new ArrayList<>();
        Request ardrRequest = new Request();
        AutoResizeDimensionsRequest ardr = new AutoResizeDimensionsRequest();
        DimensionRange dr = new DimensionRange();
        dr.setDimension("COLUMNS");
        dr.setStartIndex(0);
        dr.setEndIndex(numEncounters + 1);
        dr.setSheetId(sheet1.getProperties().getSheetId());
        ardr.setDimensions(dr);
        ardrRequest.setAutoResizeDimensions(ardr);
        requests.add(ardrRequest);

        RepeatCellRequest rcr = new RepeatCellRequest();
        GridRange gridRange = new GridRange();
        gridRange.setSheetId(sheet1.getProperties().getSheetId());
        gridRange.setStartColumnIndex(1);
        gridRange.setEndColumnIndex(numEncounters + 1);
        gridRange.setStartRowIndex(0);
        gridRange.setEndRowIndex(1);
        rcr.setRange(gridRange);

        CellData cellData = new CellData();
        CellFormat format = new CellFormat();
        cellData.setUserEnteredFormat(format);
        TextFormat textFormat = new TextFormat();
        textFormat.setBold(true);
        format.setTextFormat(textFormat);
        cellData.setUserEnteredFormat(format);
        rcr.setCell(cellData);
        Request rcrRequest = new Request();
        rcrRequest.setRepeatCell(rcr);
        rcr.setFields("UserEnteredFormat(TextFormat)");
        requests.add(rcrRequest);

        UpdateSheetPropertiesRequest usr = new UpdateSheetPropertiesRequest();
        SheetProperties sheetProperties = new SheetProperties();
        sheetProperties.setSheetId(sheet1.getProperties().getSheetId());
        GridProperties gridProperties = new GridProperties();
        gridProperties.setFrozenRowCount(1);
        sheetProperties.setGridProperties(gridProperties);
        usr.setProperties(sheetProperties);
        usr.setFields("gridProperties.frozenRowCount");
        Request usrReq = new Request();
        usrReq.setUpdateSheetProperties(usr);
        requests.add(usrReq);

        AddConditionalFormatRuleRequest acfrRed = new AddConditionalFormatRuleRequest();
        acfrRed.setIndex(0);
        ConditionalFormatRule cfrRed = new ConditionalFormatRule();
        acfrRed.setRule(cfrRed);
        GridRange grRed = new GridRange();
        grRed.setSheetId(sheet1.getProperties().getSheetId());
        grRed.setStartColumnIndex(1);
        System.out.println(numEncounters);
        grRed.setEndColumnIndex(numEncounters + 1);
        grRed.setStartRowIndex(1);
        grRed.setEndRowIndex(raiders.size() + 1);
        cfrRed.setRanges(Arrays.asList(grRed));
        BooleanRule brRed = new BooleanRule();
        cfrRed.setBooleanRule(brRed);
        CellFormat redFormat = new CellFormat();
        brRed.setFormat(redFormat);
        Color red = new Color();
        red.setRed(0.9f);
        red.setGreen(0.49f);
        red.setBlue(0.45f);
        redFormat.setBackgroundColor(red);
        BooleanCondition bcRed = new BooleanCondition();
        bcRed.setType("NUMBER_EQ");
        ConditionValue cvRed = new ConditionValue();
        cvRed.setUserEnteredValue("0");
        bcRed.setValues(Arrays.asList(cvRed));
        brRed.setCondition(bcRed);
        Request rRed = new Request();
        rRed.setAddConditionalFormatRule(acfrRed);
        requests.add(rRed);

        AddConditionalFormatRuleRequest acfrYellow = new AddConditionalFormatRuleRequest();
        acfrYellow.setIndex(0);
        ConditionalFormatRule cfrYellow = new ConditionalFormatRule();
        acfrYellow.setRule(cfrYellow);
        GridRange grYellow = new GridRange();
        grYellow.setSheetId(sheet1.getProperties().getSheetId());
        grYellow.setStartColumnIndex(1);
        grYellow.setEndColumnIndex(numEncounters + 1);
        grYellow.setStartRowIndex(1);
        grYellow.setEndRowIndex(raiders.size() + 1);
        cfrYellow.setRanges(Arrays.asList(grYellow));
        BooleanRule brYellow = new BooleanRule();
        cfrYellow.setBooleanRule(brYellow);
        CellFormat formatYellow = new CellFormat();
        brYellow.setFormat(formatYellow);
        Color yellow = new Color();
        yellow.setRed(1f);
        yellow.setGreen(0.84f);
        yellow.setBlue(0.4f);
        formatYellow.setBackgroundColor(yellow);
        BooleanCondition bcYellow = new BooleanCondition();
        bcYellow.setType("NUMBER_EQ");
        ConditionValue cvYellow = new ConditionValue();
        cvYellow.setUserEnteredValue("1");
        bcYellow.setValues(Arrays.asList(cvYellow));
        brYellow.setCondition(bcYellow);
        Request rYellow = new Request();
        rYellow.setAddConditionalFormatRule(acfrYellow);
        requests.add(rYellow);

        AddConditionalFormatRuleRequest acfrgreen = new AddConditionalFormatRuleRequest();
        acfrgreen.setIndex(0);
        ConditionalFormatRule cfrgreen = new ConditionalFormatRule();
        acfrgreen.setRule(cfrgreen);
        GridRange grgreen = new GridRange();
        grgreen.setSheetId(sheet1.getProperties().getSheetId());
        grgreen.setStartColumnIndex(1);
        grgreen.setEndColumnIndex(numEncounters + 1);
        grgreen.setStartRowIndex(1);
        grgreen.setEndRowIndex(raiders.size() + 1);
        cfrgreen.setRanges(Arrays.asList(grgreen));
        BooleanRule brgreen = new BooleanRule();
        cfrgreen.setBooleanRule(brgreen);
        CellFormat greenFormat = new CellFormat();
        brgreen.setFormat(greenFormat);
        Color green = new Color();
        green.setRed(.34f);
        green.setGreen(0.73f);
        green.setBlue(0.54f);
        greenFormat.setBackgroundColor(green);
        BooleanCondition bcgreen = new BooleanCondition();
        bcgreen.setType("NUMBER_EQ");
        ConditionValue cvgreen = new ConditionValue();
        cvgreen.setUserEnteredValue("2");
        bcgreen.setValues(Arrays.asList(cvgreen));
        brgreen.setCondition(bcgreen);
        Request rgreen = new Request();
        rgreen.setAddConditionalFormatRule(acfrgreen);
        requests.add(rgreen);

        batchReq.setRequests(requests);
        SheetsApi.getService().spreadsheets().batchUpdate(spreadsheet.getSpreadsheetId(), batchReq)
                .execute();

        raiders = raiders.subList(0, 2);
        ExecutorService                  service        = Executors.newFixedThreadPool(4);
        Map<String, Future<List<SItem>>> upgradeFutures = new HashMap<>();
        for (SGuild.SMemberCharacter raider : raiders) {
            upgradeFutures.put(raider.name, service.submit(RaidBotsAPI.selectBetterItemsCallable("Lightbringer", raider.name)));
        }

        List<List<Object>> upgradeCells = new ArrayList<>();
        for (String raider : upgradeFutures.keySet()) {
            List<SItem> upgrades = upgradeFutures.get(raider).get();
            System.out.println(raider + ":");
            System.out.println("");
            List<Object> upgradeRow = new ArrayList<>();
            upgradeRow.add(raider);
            Map<Long, List<SItem>> encounterToUpgrade = new HashMap<>();
            for (SItem upgrade : upgrades) {
                SInstance.SEncounter encounter = SInstance.getEncounter(upgrade.sources.get(0).encounterId);
                List<SItem> existingUpgrades = encounterToUpgrade.getOrDefault(encounter.id, new ArrayList<>());
                existingUpgrades.add(upgrade);
                encounterToUpgrade.put(encounter.id, existingUpgrades);
                System.out.println(upgrade.name + " - " + encounter.name);
            }

            for (SInstance.SEncounter encounter : instance.encounters) {
                List<SItem> items = encounterToUpgrade.getOrDefault(encounter.id, new ArrayList<>());
                if (items.isEmpty()) {
                    upgradeRow.add(0);
                } else if (items.size() == 1) {
                    upgradeRow.add(1);
                } else {
                    upgradeRow.add(2);
                }
            }
        }

        ValueRange upgradeRange = new ValueRange().setValues(upgradeCells);
        SheetsApi.getService().spreadsheets().values().update(spreadsheet.getSpreadsheetId(),"A2:Z10", upgradeRange)
                .setValueInputOption("USER_ENTERED")
                .execute();


    }
}
