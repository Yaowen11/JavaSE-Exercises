package se.collection.list;

class StringAddress {
    private String s;
    public StringAddress(String s) {
        this.s = s;
    }
    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
