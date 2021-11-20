package ru.avalon.javapp.devj120;

import java.util.Objects;

public class PhoneNumber {
    private final String areaCode;
    private final String localNum;
    private String strImg;

    public PhoneNumber(String areaCode, String localNum) {
        checkValue(areaCode, "area code");
        checkValue(localNum, "local number");
        this.areaCode = areaCode;
        this.localNum = localNum;
    }

    private void checkValue(String value, String partName) {
        if (value == null)
            throw new NullPointerException("'" + partName + "' is null.");
        if (value.length() == 0)
            throw new IllegalArgumentException("'" + partName + "' is empty string.");
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException("'" + partName + "' contains illegal characters.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (! (obj instanceof PhoneNumber))
            return false;
        PhoneNumber other = (PhoneNumber) obj;
        return this.areaCode.equals(other.areaCode) && this.localNum.equals(other.localNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, localNum);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getLocalNum() {
        return localNum;
    }

    @Override
    public String toString() {
        if(strImg == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('(').append(areaCode).append(')');
            int p = localNum.length() % 2 + 2;
            if (p < localNum.length()) {
                sb.append(localNum, 0, p);
                while (p <= (localNum.length() - 2)){
                    sb.append('-').append(localNum, p, p+2);
                    p+=2;
                }
            } else
                sb.append(localNum);
            strImg = sb.toString();
        }
        return strImg;
    }
}
