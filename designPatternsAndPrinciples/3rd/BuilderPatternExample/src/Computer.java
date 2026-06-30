public class Computer {
    // Required parameters
    private String cpu;
    private String ram;
    private String storage;

    // Optional parameters
    private boolean bluetoothEnabled;
    private boolean wifiEnabled;

    // Private constructor that takes Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.bluetoothEnabled = builder.bluetoothEnabled;
        this.wifiEnabled = builder.wifiEnabled;
    }
    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private String cpu;
        private String ram;
        private String storage;

        // Optional parameters - initialized to default values
        private boolean bluetoothEnabled = false;
        private boolean wifiEnabled = false;

        // Constructor with required parameters
        public Builder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        // Methods to set optional parameters (return Builder for chaining)
        public Builder setBluetooth(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Builder setWifi(boolean wifiEnabled) {
            this.wifiEnabled = wifiEnabled;
            return this;
        }

        // build() method returns the Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
    // Getters
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public boolean isBluetoothEnabled() { return bluetoothEnabled; }
    public boolean isWifiEnabled() { return wifiEnabled; }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + cpu + '\'' +
                ", RAM='" + ram + '\'' +
                ", Storage='" + storage + '\'' +
                ", Bluetooth=" + bluetoothEnabled +
                ", WiFi=" + wifiEnabled +
                '}';
    }
}