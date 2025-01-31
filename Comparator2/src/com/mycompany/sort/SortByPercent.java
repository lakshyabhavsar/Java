
package com.mycompany.sort;

import com.mycompany.student.Student;
import java.util.Comparator;

public class SortByPercent implements Comparator<Student>
{

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getPercent()>s2.getPercent())
        {
            return 1;
        }
        
        else if(s1.getPercent()<s2.getPercent())
        {
            return -1;
        }
        
        else
        {
            return 0;
        }
    }
    
}
