/*
 * No licence applied
 */
package objectcomparator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Kerry Billingham <contact@AvionicEngineers.com>
 */
public class ObjectComparator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ObjectComparator oc = new ObjectComparator();

        TypeOneObject t1 = new TypeOneObject();
        TypeOneObject t2 = new TypeOneObject();
        TypeTwoObject t22 = new TypeTwoObject();
        TypeTwoObject t23 = new TypeTwoObject();

        t1.setIdentity(10);
        t1.setName("this is my name");
        t1.setFirstValue(1L);
        t2.setPrimitiveLong(1L);
        t1.setTypeTwoObject(t22);
        t2.setTypeTwoObject(t23);
        t22.setIdent("this ident");
        t23.setIdent("this not ident");

        oc.compareThese(t1, t2).stream()
                .forEach(field -> System.out.println(field));
    }

    private <T> List<String> compareThese(T object1, T object2) throws ObjectMismatchException, IllegalAccessException {
        if (!object1.getClass().equals(object2.getClass())) {
            throw new ObjectMismatchException();
        }
        final List<String> mismatchingFields = new ArrayList<>();

        Class<?> object1Class = object1.getClass();
        while (object1Class != null && object1Class != Object.class) {
            Field[] object1Fields = object1Class.getDeclaredFields();

            for (Field field : object1Fields) {
                EditableField editableField = field.getDeclaredAnnotation(EditableField.class);
                if (editableField != null) {
                    field.setAccessible(true);
                    if (!Optional.ofNullable(field.get(object1)).equals(Optional.ofNullable(field.get(object2)))) {
                        mismatchingFields.add(field.getName());
                    }
                }
            }
            object1Class = object1Class.getSuperclass();
        }
        return mismatchingFields;
    }

}
