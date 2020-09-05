package com.sparrowsanta.real_estate_management_rest.rent;

import com.sparrowsanta.real_estate_management_rest.client.Client;
import com.sparrowsanta.real_estate_management_rest.room.Room;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class RentService implements AbstractBaseService<Rent, Long> {

    private RentRepository rentRepository;
    private String rentDateFrom;
    private String rentDateTo;
    private LocalDate rentDateFromL;
    private LocalDate rentDateToL;
    private final PageRequest pageRequest = PageRequest.of(0, 1);

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }


    @Override
    public Rent save(Rent entity) {
        Rent rent = rentRepository.save(entity);
        return rent;
    }

    @Override
    public List<Rent> findAll() {
        List<Rent> rents = rentRepository.findAll();
        return rents;
    }

    @Override
    public Optional<Rent> findById(Long entityId) {
        Optional<Rent> rentOptional = rentRepository.findById(entityId);
        return rentOptional;
    }

    @Override
    public Rent update(Rent entity) {
        Rent rent = rentRepository.save(entity);
        return rent;
    }

    @Override
    public Rent updateById(Rent entity, Long entityId) {
        Optional<Rent> rentOptional = rentRepository.findById(entityId);
        if (rentOptional.isPresent()) {
            return rentRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Rent entity) {
        rentRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        rentRepository.deleteById(entityId);
    }

    @Override
    public Rent getOne(Long entityId) {
        Rent rent = rentRepository.getOne(entityId);
        return rent;
    }

    public List<Rent> getRentHistoryByRoomId(long roomId) {
        List<Rent> rentByRoomId = rentRepository.getRentByRoomId(roomId);
        return rentByRoomId;
    }

    public Rent saveRent(Client client, Room room, Map<String, String> maps) {
        Rent rent = new Rent();
        rent.setRentAmount(Long.parseLong(maps.get("rentAmount")));
        rent.setRoom(room);
        rent.setClient(client);

        rentDateFrom = maps.get("rentDateFrom");
        rentDateTo = maps.get("rentDateTo");
        rentDateFromL = LocalDate.parse(rentDateFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rentDateToL = LocalDate.parse(rentDateTo, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        rent.setRentDateFrom(rentDateFromL);
        rent.setRentDateTo(rentDateToL);

        return rentRepository.save(rent);
    }

    public Rent updateRent(Client client, Room room, Map<String, String> maps, long rentId) {
        Rent rent = new Rent();
        rent.setRentAmount(Long.parseLong(maps.get("rentAmount")));
        rent.setRoom(room);
        rent.setClient(client);

        rentDateFrom = maps.get("rentDateFrom");
        rentDateTo = maps.get("rentDateTo");
        rentDateFromL = LocalDate.parse(rentDateFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rentDateToL = LocalDate.parse(rentDateTo, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        rent.setRentDateFrom(rentDateFromL);
        rent.setRentDateTo(rentDateToL);
        rent.setId(rentId);
        return rentRepository.save(rent);
    }

    public List<Rent> getMostRecentRent(long roomId) {
        return rentRepository.getMostRecentRent(roomId, pageRequest);
    }


}