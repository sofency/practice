package top.sofency.entity;

import java.io.Serializable;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.entity
 * @Version: 1.0
 */
public class TrainItem implements Serializable {
    private Integer itemId;
    private String itemName;

    public TrainItem() {
        super();
    }

    public TrainItem(Integer itemId, String itemName) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
