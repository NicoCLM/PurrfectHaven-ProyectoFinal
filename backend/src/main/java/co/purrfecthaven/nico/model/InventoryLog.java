package co.purrfecthaven.nico.model;
import java.util.Date;
/**
 * InventoryLogDTO
 */
public class InventoryLog {
    private int logId;
    private int productId;
    private int quantityChange;
    private String changeReason;
    private Date changeDate;
}
