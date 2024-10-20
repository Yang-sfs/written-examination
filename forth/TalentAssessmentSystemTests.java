package Code.forth;

public class TalentAssessmentSystemTests {
    
    public void TestFindMedianTalentIndex() {
        int[] fireAbility = { 1, 3, 7, 9, 11 };
        int[] iceAbility = { 2, 4, 8, 10, 12, 14 };
        System.out.println(TalentAssessmentSystem.FindMedianTalentIndex(fireAbility, iceAbility));
    }

    public static void main(String[] args) {
        TalentAssessmentSystemTests talentAssessmentSystemTests = new TalentAssessmentSystemTests();
        talentAssessmentSystemTests.TestFindMedianTalentIndex();
    }

}
