package top.sofency.dao;

import top.sofency.entity.TrainItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.dao
 * @Version: 1.0
 */
public interface TrainItemDao {
    public ArrayList<TrainItem> selectAll();
}
