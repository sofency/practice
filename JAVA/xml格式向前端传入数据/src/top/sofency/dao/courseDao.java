package top.sofency.dao;

import top.sofency.entity.Course;

import java.util.ArrayList;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.dao
 * @Version: 1.0
 */
public interface courseDao {
    public ArrayList<Course> selectByItemId(int id);
    public Course selectByCourseId(int id);
}
