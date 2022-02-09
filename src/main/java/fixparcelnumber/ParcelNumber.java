package fixparcelnumber;

public class ParcelNumber {

    private String parcel;

    public ParcelNumber(String parcel) {
        this.parcel = parcel;
    }

    public void fixWrongSubpartConcatenation() {
        int indexOfSlash = this.parcel.lastIndexOf('/');
        char[] chars = this.parcel.toCharArray();
        if (indexOfSlash > 0 && chars.length - 1 == indexOfSlash) {
            this.parcel = this.parcel.substring(0, parcel.length() - 1);
        } else if (indexOfSlash > 0 && Character.isAlphabetic(chars[indexOfSlash + 1])) {
            this.parcel = this.parcel.substring(0, indexOfSlash) + this.parcel.substring(indexOfSlash + 1);
        }
    }

    public String getParcel() {
        return parcel;
    }
}
