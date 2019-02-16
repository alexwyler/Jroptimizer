import battlenet.BattleNetApi;
import battlenet.objects.SGuild;
import com.google.api.services.sheets.v4.model.*;
import raidbots.RaidBotsAPI;
import raidbots.objects.Character;
import raidbots.objects.SInstance;
import raidbots.objects.SItem;
import raidbots.objects.Talent;
import sheets.SheetsApi;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        String realm = "Lightbringer";

        SGuild guild = BattleNetApi.getGuildMembers(realm, "Resident Kabuki Theatre");
        List<SGuild.SMemberCharacter> raiders = guild.members.stream().filter(m -> {
            if (m.rank == 1) {
                if (!RKT_OFFICER_WHITELIST.contains(m.character.name)) {
                    return false;
                }
            }
            return Arrays.asList(0l, 1l, 4l).contains(m.rank) && m.character.level == 120l;
        }).map(m -> m.character).collect(Collectors.toList());

        SInstance    instance       = SInstance.getInstanceForName("Battle of Dazar'alor");
        List<Object> encounterNames = instance.encounters.stream().map(e -> e.name).collect(Collectors.toList());
        int          numEncounters  = encounterNames.size();

        Spreadsheet spreadsheet = SheetsApi.getOrCreateSpreadsheetFromDB();
        Sheet       sheet1      = spreadsheet.getSheets().get(0);

        List<List<Object>> values = Arrays.asList(
                encounterNames
        );

        ValueRange body = new ValueRange()
                .setValues(values);

        SheetsApi.getService().spreadsheets().values().update(spreadsheet.getSpreadsheetId(), "B1:J1", body)
                .setValueInputOption("USER_ENTERED")
                .execute();

        BatchUpdateSpreadsheetRequest batchReq    = new BatchUpdateSpreadsheetRequest();
        List<Request>                 requests    = new ArrayList<>();
        Request                       ardrRequest = new Request();
        AutoResizeDimensionsRequest   ardr        = new AutoResizeDimensionsRequest();
        DimensionRange                dr          = new DimensionRange();
        dr.setDimension("COLUMNS");
        dr.setStartIndex(0);
        dr.setEndIndex(numEncounters + 1);
        dr.setSheetId(sheet1.getProperties().getSheetId());
        ardr.setDimensions(dr);
        ardrRequest.setAutoResizeDimensions(ardr);
        requests.add(ardrRequest);

        RepeatCellRequest rcr       = new RepeatCellRequest();
        GridRange         gridRange = new GridRange();
        gridRange.setSheetId(sheet1.getProperties().getSheetId());
        gridRange.setStartColumnIndex(1);
        gridRange.setEndColumnIndex(numEncounters + 1);
        gridRange.setStartRowIndex(0);
        gridRange.setEndRowIndex(1);
        rcr.setRange(gridRange);

        CellData   cellData = new CellData();
        CellFormat format   = new CellFormat();
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

        UpdateSheetPropertiesRequest usr             = new UpdateSheetPropertiesRequest();
        SheetProperties              sheetProperties = new SheetProperties();
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
        grRed.setEndColumnIndex(numEncounters + 1);
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

        ExecutorService                  service        = Executors.newFixedThreadPool(4);

        Map<String, Future> futures = new HashMap<>();
        for (SGuild.SMemberCharacter raider : raiders) {
            futures.put(raider.name, service.submit(() -> {

                List<List<Object>> upgradeCells;
                boolean isDps = false;
                Character character = RaidBotsAPI.fetch(realm, raider.name);
                for (Talent talent : character.getTalents()) {
                    if (!talent.getSelected()) {
                        continue;
                    }
                    isDps = "DPS".equals(talent.getSpec().getRole());
                    break;
                }
                if (isDps) {
                    List<SItem> upgrades;
                    try {
                        upgrades = RaidBotsAPI.selectBetterItemsCallable("Lightbringer", raider.name).call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(raider.name + ": " + upgrades.size() + " available upgrades found!");
                    List<Object> upgradeRow = new ArrayList<>();
                    upgradeRow.add(raider.name);
                    Map<Long, List<SItem>> encounterToUpgrade = new HashMap<>();
                    for (SItem upgrade : upgrades) {
                        SInstance.SEncounter encounter        = SInstance.getEncounter(upgrade);
                        List<SItem>          existingUpgrades = encounterToUpgrade.getOrDefault(encounter.id, new ArrayList<>());
                        existingUpgrades.add(upgrade);
                        encounterToUpgrade.put(encounter.id, existingUpgrades);
                    }

                    for (SInstance.SEncounter encounter : instance.encounters) {
                        List<SItem> items = encounterToUpgrade.getOrDefault(encounter.id, new ArrayList<>());
                        if (items.size() <= 4) {
                            upgradeRow.add(items.size() / 2);
                        } else {
                            upgradeRow.add(2);
                        }
                    }
                    upgradeCells = Arrays.asList(upgradeRow);
                } else {
                    upgradeCells = Arrays.asList(Arrays.asList(raider.name));
                }
                ValueRange         upgradeRange = new ValueRange().setValues(upgradeCells);

                int raiderIndex = IntStream.range(0, raiders.size())
                        .filter(i -> raiders.get(i).name.equals(raider.name))
                        .findFirst()
                        .getAsInt();
                // A1 notation starts at 1 and we have a header row
                int row = raiderIndex + 2;

                System.out.println("Publishing row for " + raider.name);
                try {
                    SheetsApi.getService()
                            .spreadsheets()
                            .values()
                            .update(spreadsheet.getSpreadsheetId(), String.format("A%d:J%d", row, row), upgradeRange)
                            .setValueInputOption("USER_ENTERED")
                            .execute();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        for (Map.Entry<String, Future> entry : futures.entrySet()) {
            try {
                entry.getValue().get();
            } catch (ExecutionException e) {
                // Don't bomb all rows just because at least one
                e.printStackTrace();
            }
        }

        System.out.println("DONE");
    }
}
