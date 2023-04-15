public class Data {
    private long account;
    private String name;
    private double value;

    public Data(long account, String name, double value) {
        this.account = account;
        this.name = name;
        this.value = value;
    }
    public Data(Data data){
        this.account = data.getAccount();
        StringBuilder sb = new StringBuilder();
        sb.append(data.getName());
        this.name = sb.toString();
        this.value = data.getValue();
    }

    public long getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
