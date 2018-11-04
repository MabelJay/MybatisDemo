package mybatisPack;

import org.apache.ibatis.annotations.Select;

public interface MapperClass {

	@Select("select * from student where sid=#{id};")
	public String selectOneStudent(int id); 
}
