package customSorting;

import java.util.Comparator;

import sdbms.Student2;

public class SortStudentById implements Comparator<Student2>{

	@Override
	public int compare(Student2 x, Student2 y) {
		// TODO Auto-generated method stub
		return x.getId().compareTo(y.getId());
	}

}
