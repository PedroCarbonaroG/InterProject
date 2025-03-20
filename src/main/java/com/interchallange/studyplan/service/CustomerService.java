package com.interchallange.studyplan.service;

import com.interchallange.studyplan.domain.entity.Customer;
import com.interchallange.studyplan.repository.CustomerRepository;
import com.interchallange.studyplan.service.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderService orderService;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]{7,}@[A-Za-z0-9.-]+\\.com$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{2}9\\d{8}$");

    public Page<Customer> listAll(String filterByName, Pageable pageRequest) {
        return customerRepository.listAll(filterByName, pageRequest);
    }

    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    public void delete(String id) {

        if (Objects.isNull(orderService.findByCustomerId(id))) { customerRepository.delete(id); }
        else { throw new RuntimeException("This customer has orders so can't be deleted"); }
    }

    public Customer create(Customer customer) {

        validateNewCustomerFields(customer);
        return customerRepository.save(customer);
    }

    public Customer update(String id, Customer customer) {

        var originalCustomer = findById(id);
        var updatedCustomer = validateFields(customer, originalCustomer);

        return customerRepository.update(updatedCustomer);
    }

    private void validateNewCustomerFields(Customer customer) {

        validateValidEmail(customer.getEmail());

        if (isFilledField(customer.getPhoneNumber())) {
            validateValidPhoneNumber(customer.getPhoneNumber());
        } else {
            customer.setPhoneNumber(StringUtils.EMPTY);
        }
    }

    private Customer validateFields(Customer newCustomer, Customer originalCustomer) {

        var customerBuilder = Customer.builder();

        if (isFilledField(newCustomer.getEmail())) {
            validateValidEmail(newCustomer.getEmail());
            customerBuilder.email(newCustomer.getEmail());
        } else {
            customerBuilder.email(originalCustomer.getEmail());
        }

        if (isFilledField(newCustomer.getPhoneNumber())) {
            validateValidPhoneNumber(newCustomer.getPhoneNumber());
            customerBuilder.phoneNumber(newCustomer.getPhoneNumber());
        } else {
            customerBuilder.phoneNumber(originalCustomer.getPhoneNumber());
        }

        return customerBuilder
                .id(originalCustomer.getId())
                .name(isFilledField(newCustomer.getName()) ? newCustomer.getName() : originalCustomer.getName())
                .build();
    }

    private <T> boolean isFilledField(T field) {
        return Objects.nonNull(field) && !field.toString().isEmpty();
    }

    private void validateValidPhoneNumber(String phoneNumber) {
        if (!(phoneNumber != null && PHONE_PATTERN.matcher(phoneNumber).matches())) { throw new ValidationException("Invalid phone number, wasn't 11 digits or pattern is wrong"); }
    }

    private void validateValidEmail(String email) {
        if (!(email != null && EMAIL_PATTERN.matcher(email).matches())) { throw new ValidationException("Invalid email, initial email wasn't 7 characters or pattern is wrong"); }
    }

}
