/*
 * No licence applied
 */
package objectcomparator;

/**
 *
 * @author Kerry Billingham <contact@AvionicEngineers.com>
 */
public class TypeOneObject extends CommonObject{

    @EditableField
    private String name;

    @EditableField
    private Long firstValue;

    @EditableField
    private long primitiveLong;

    private String uneditableField;

    @EditableField
    private TypeTwoObject typeTwoObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Long firstValue) {
        this.firstValue = firstValue;
    }

    public long getPrimitiveLong() {
        return primitiveLong;
    }

    public void setPrimitiveLong(long primitiveLong) {
        this.primitiveLong = primitiveLong;
    }

    public String getUneditableField() {
        return uneditableField;
    }

    public void setUneditableField(String uneditableField) {
        this.uneditableField = uneditableField;
    }

    public TypeTwoObject getTypeTwoObject() {
        return typeTwoObject;
    }

    public void setTypeTwoObject(TypeTwoObject typeTwoObject) {
        this.typeTwoObject = typeTwoObject;
    }

    


}
