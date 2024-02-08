package customSorting;
import java.util.Comparator;
import sdbms.Student;
public class SortStudentByAge implements Comparator<Student> {

	@Override
	public int compare(Student x,Student y) {
		return x.getAge() - y.getAge();
	}
}
//x--object to be inserted & y-->alarday existing object
