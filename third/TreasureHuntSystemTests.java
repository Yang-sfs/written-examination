package Code.third;

public class TreasureHuntSystemTests {
    
    public void TestMaxTreasureValue() {
        int[] treasures = {3, 1, 5, 2, 4};
        System.out.println(TreasureHuntSystem.MaxTreasureValue(treasures));
    }

    public static void main(String[] args) {
        TreasureHuntSystemTests treasureHuntSystemTests = new TreasureHuntSystemTests();
        treasureHuntSystemTests.TestMaxTreasureValue();
    }

}
