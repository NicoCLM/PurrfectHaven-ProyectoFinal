package co.purrfecthaven.nico.dto;
import java.util.Date;
/**
 * InventoryLogDTO
 */
public class InventoryLogDTO {
    private int logId;
    private int productId;
    private int quantityChange;
    private String changeReason;
    private Date changeDate;
}
