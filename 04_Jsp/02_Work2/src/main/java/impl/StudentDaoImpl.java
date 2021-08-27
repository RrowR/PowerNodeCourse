package impl;

import common.PageInfo;
import dao.BaseDao;
import dao.StudentDao;
import entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public int addStudent(Student student) {
        // 这里只能写? 不能写 '?' 否则会报错
        String sql = "insert into student(name,address,age,sex,birth) value (?,?,?,?,?)";
        /*
            这里很不建议丢对象进去，等下在BaseDao中取出来会非常地麻烦，不仅可能要强转，还会导致其他方法无法调用,破坏了程序的扩展性
            并且后面循环遍历param也相当的不对，和?个数不对应
         */
        String name = student.getName();
        String address = student.getAddress();
        Integer age = student.getAge();
        Integer sex = student.getSex();
        Date birth = student.getBirth();
        Object[] params = {name, address, age, sex, birth};
        return super.executeUpdate(sql, params);
    }

    @Override
    public int deleteStudent(Integer id) {
        String sql = "delete from student where id = ?";
        Object[] params = {id};
        return super.executeUpdate(sql, params);
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set name = ?,address = ?,age = ?,sex = ?,birth = ? where id = ?";
        String name = student.getName();
        String address = student.getAddress();
        Integer age = student.getAge();
        Integer sex = student.getSex();
        Date birth = student.getBirth();
        Integer id = student.getId();
        Object[] params = {name, address, age, sex, birth, id};
        return super.executeUpdate(sql, params);
    }

    @Override
    public Student queryStudentById(Integer id) {
        Object[] params = {id};
        String sql = "select * from student where id = ?";
        return super.selectOne(sql, Student.class, params);
    }

    /*
        查询所有学生，返回一个List<Student>集合
     */
    @Override
    public List<Student> queryAllStudent() {
        String sql = "select * from student";
        Object[] params = null;
        // 核心就是调用BaseDao里的（selectList方法）去查询数据库，这个方法
        return super.selectList(sql, Student.class, params);      // 调用父类的selectList方法，返回一个List集合
    }

    /**
     *
     * @param pageInfo      这里面传入pageInfo，调用方法的时候只需要传入页码数和每页的页数
     * @param student       这里的对象不一定需要传入所有属性，只需要传入自己想要传入的属性进行set进去即可
     * @return
     */
    @Override
    public PageInfo<Student> queryPageStudent(PageInfo pageInfo, Student student) {
        /*
            先分析Student表，发现最多只能根据name、address来进行模糊查询
            其他字段要么不是字符串，要么是单个sex字符没法模糊查询
            但是可以根据sex进行等值查询
         */
        // 如果下面的sql语句不执行，那么此sql也不会报错
        StringBuilder builder = new StringBuilder("select * from student where 1=1");
        // 还需要创建一个集合用来存储sql占位符条件，当满足条件则存储
        ArrayList<String> list = new ArrayList<>();
        // 判断如果传入的对象的名字不为空
        if (student.getName() != null && !student.getName().equals("")) {
            // '%?%' 这样的写法是错误的
            builder.append(" and name like concat('%',?,'%') ");
            list.add(student.getName());
        }
        if (student.getAddress() != null && !student.getAddress().equals("")) {
//            concat('%',?,'%')
            builder.append(" and address like concat('%',?,'%') ");
            list.add(student.getAddress());
        }
        if (student.getSex() != null && !student.getSex().equals("")) {
            builder.append(" and sex = ?");
            list.add(student.getSex().toString());
        }
        Object[] params = list.toArray();
        String sql = builder.toString();
        return super.queryForPage(sql, Student.class, pageInfo, params);
    }
}
