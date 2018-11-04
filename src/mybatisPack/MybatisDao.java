package mybatisPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MybatisDao {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getSqlSession();
			String res = sqlSession.selectOne("selectOne",1);
			System.out.println(res);
			List<String> list = sqlSession.selectList("selectAll");
			System.out.println(list);
			List<HashMap<String, String>> map = new ArrayList<>();
			map = sqlSession.selectList("selectAll2");
			System.out.println(map);
			
			/*//test MapperClass 
			MapperClass mapperClass = sqlSession.getMapper(MapperClass.class);
			System.out.println("mapper class:"+mapperClass);
			mapperClass.selectOneStudent(2);*/
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MybatisUtils.closeSqlSession();
		}
	}
}
