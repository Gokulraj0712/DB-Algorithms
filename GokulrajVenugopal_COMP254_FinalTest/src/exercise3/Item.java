package exercise3;

public class Item implements Comparable<Item> {

	 // private instance attributes
    private int itemId;
    private String itemName;
    private double itemPrice;

    public Item(int itemId, String itemName, double itemPrice) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public double getPriceOfItem() {
        return itemPrice;
    }

    public void setPriceOfItem(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * method compares two Item objects for sorting
     */
    @Override
    public int compareTo(Item item) {
        int result;
        // current item object price is smaller
        if (this.itemPrice < item.getPriceOfItem())
            result = -1;
        else if (this.itemPrice > item.getPriceOfItem())//price higher
            result = 1;
        else //same prices
            result = 0;
        return result;
    }

    /**
     * provides Item detail
     */
    @Override
    public String toString() {
        return  itemName+"[ID = " + itemId + ", Price = $" + itemPrice + "]\n";
    }


	
	
}
