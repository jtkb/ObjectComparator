/*
 * No licence applied
 */
package objectcomparator;

import java.util.Optional;

/**
 *
 * @author Kerry Billingham <contact@AvionicEngineers.com>
 */
public class TypeTwoObject {

    @EditableField
    private String ident;

    @EditableField
    private Long serialNumber;

    @EditableField
    private long classificationCode;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(long classificationCode) {
        this.classificationCode = classificationCode;
    }

    @Override
    public boolean equals(Object obj) {
        return Optional.ofNullable(ident).equals(Optional.ofNullable(((TypeTwoObject)obj).getIdent()));
    }
}
