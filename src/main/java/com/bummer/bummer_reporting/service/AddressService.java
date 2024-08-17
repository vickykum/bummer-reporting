package com.bummer.bummer_reporting.service;

import com.bummer.bummer_reporting.dao.AddressDao;
import com.bummer.bummer_reporting.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    public List<Address> getAddressesByLatLon(Double latitude, Double longitude) {
        return addressDao.findByLatitudeAndLongitude(latitude, longitude);
    }

    public List<Address> getAddressesByCityAndState(String city, String state) {
        return addressDao.findByCityAndState(city, state);
    }

    public List<Address> getAddressesByCityAndStateAnsCountry(String city, String state, String country) {
        return addressDao.findByCityAndStateAndCountry(city, state, country);
    }

    public Address getAddressByRestaurantId(Long restaurantId) {
        return addressDao.findByRestaurantId(restaurantId);
    }

    public List<Address> getAddressesByPostcode(String postcode) {
        return addressDao.findByPostcode(postcode);
    }

    public Address getAddressById(Long id) {
        return addressDao.findById(id).orElse(null);
    }
}
