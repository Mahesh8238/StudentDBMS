package customSorting;

import java.util.Comparator;

import sdbms.Student2;

public class SortStudentByAge implements Comparator<Student2> {

	@Override
	public int compare(Student2 x, Student2 y) {
		// TODO Auto-generated method stub
		return x.getAge()-y.getAge();
	}

}
