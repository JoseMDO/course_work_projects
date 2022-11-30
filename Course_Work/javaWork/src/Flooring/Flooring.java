package Flooring;

public class Flooring {
    public static void main(String[] args) {
    int rectArea = 25 * 7;
    int squareArea = 8 * 8;
    int trianlgeArea = (1/2)*(8 * 9);
    int totalSqFt = rectArea + squareArea + trianlgeArea;
    int squareftPerTile = (24 * 6) / 144;
    double packagesNeeded = totalSqFt / (squareftPerTile * 8);
    double extraBoxes = packagesNeeded * .25;
    int totalPackagesNeeded = (int)Math.ceil(packagesNeeded + extraBoxes);
    double pricePerPackage = 24.99;
    double totalPrice = totalPackagesNeeded * pricePerPackage;
        
    System.out.printf("For this room with an area of: %d square feet\n", totalSqFt);
    System.out.printf("You will need %d packages of tile. \nThat inlcudes the 25%% more than what is actually needed just in case.\n", totalPackagesNeeded);
    System.out.printf("The total for these packages at $24.99 per box will come out to: $%.2f", totalPrice);
    

    }


}
