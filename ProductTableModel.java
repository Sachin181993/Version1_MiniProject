import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductTableModel extends AbstractTableModel
{

	private List<Product> products;

	public ProductTableModel(List<Product> products) {
		this.products = new ArrayList<>(products);
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		String name = "??";
		switch (column) {
			case 0:
				name = "Name";
				break;
			case 1:
				name = "Description";
				break;
			case 2:
				name = "Value";
				break;
		}
		return name;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class type = String.class;
		switch (columnIndex) {
			case 0:
				type = String.class;
				break;
			case 1:
				type = String.class;
				break;
			case 2:
				type = Integer.class;
				break;
		}
		return type;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = products.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
			case 0:
				value = product.getProductName();
				break;
			case 1:
				value = product.getProdDesc();
				break;
			case 2:
				value = product.getProdValue();
				break;
		}
		return value;
	}
}        
