package customSorting;

import java.util.Comparator;

import sdbms.Student2;

public class SortStudentByName implements Comparator<Student2> {

	@Override
	public int compare(Student2 x, Student2 y) {
		// TODO Auto-generated method stub
		return x.getName().compareTo(y.getName());
	}

}
