package userManagementService;

import java.util.List;

import model.Item;
import model.User;
import mysqldao.ItemMySQLDAO;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;

public interface WatchListUserService {
	
	public List<Item> getWatchListItems(User u);
	
	public boolean exportList(User u, int typeOfReport);
	
	public boolean deleteFromWatchList(Item i, User u);
	
	public boolean addToWatchList(Item i, User u);
	
}
