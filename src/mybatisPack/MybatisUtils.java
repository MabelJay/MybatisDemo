package mybatisPack;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static ThreadLocal<SqlSession> threadLocale = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private MybatisUtils() {
		
	}
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = threadLocale.get();
		if(sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
			threadLocale.set(sqlSession);
		}
		return sqlSession;
	}
	
	public static void closeSqlSession() {
		SqlSession sqlSession = threadLocale.get();
		if(sqlSession != null) {
			sqlSession.close();
			threadLocale.remove();
		}
	}

}
