package dao;

import pojos.Address;

public interface IAddressDao {
	String assignUserAddress(long userId,Address address);

}
