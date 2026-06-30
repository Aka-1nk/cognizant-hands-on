public class BuilderPatternTest {
    public static void main(String[] args) {

        // Create a basic computer (only required parameters)
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB", "256GB SSD")
                .build();

        // Create a gaming computer with optional features
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB", "1TB SSD")
                .setBluetooth(true)
                .setWifi(true)
                .build();

        // Create a work computer
        Computer workComputer = new Computer.Builder("Intel i7", "16GB", "512GB SSD")
                .setWifi(true)
                .build();

        // Print all configurations
        System.out.println("=== Computer Configurations ===");
        System.out.println("1. Basic Computer:");
        System.out.println(basicComputer);

        System.out.println("\n2. Gaming Computer:");
        System.out.println(gamingComputer);

        System.out.println("\n3. Work Computer:");
        System.out.println(workComputer);

        // Access individual properties
        System.out.println("\n=== Accessing Properties ===");
        System.out.println("Gaming Computer CPU: " + gamingComputer.getCpu());
        System.out.println("Gaming Computer RAM: " + gamingComputer.getRam());
        System.out.println("Bluetooth Enabled: " + gamingComputer.isBluetoothEnabled());
    }
}