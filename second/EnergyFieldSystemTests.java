public class EnergyFieldSystemTests {

    public void TestMaxEnergyField() {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(EnergyFieldSystem.MaxEnergyField(heights));
    }

    public static void main(String[] args) {
        EnergyFieldSystemTests energyFieldSystemTests = new EnergyFieldSystemTests();
        energyFieldSystemTests.TestMaxEnergyField();
    }
}
