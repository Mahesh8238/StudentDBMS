package customSorting;

import java.util.Comparator;

import sdbms.Student2;

public class SortStudentByMarks implements Comparator<Student2>{

	@Override
	public int compare(Student2 x, Student2 y) {
		// TODO Auto-generated method stub
		return (int) (x.getMarks()-y.getMarks());
	}

}
//x-> object to be inserted y->already exsting object