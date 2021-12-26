package com.lyess.network_device_inventory.service;

import com.lyess.network_device_inventory.converter.IModelMapper;
import com.lyess.network_device_inventory.domain.entites.NetworkDevice;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.repository.INetworkDeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 2:31 p.m.
 */
@Service
public class NetworkDeviceService implements IService<NetworkDevice, NetworkDeviceDto> {

    private static final Logger logger = LoggerFactory.getLogger(NetworkDeviceService.class);

    private final INetworkDeviceRepository networkDeviceRepository;

    private final IModelMapper<NetworkDeviceDto, NetworkDevice> converter;

    @Autowired
    public NetworkDeviceService(INetworkDeviceRepository networkDeviceRepository, IModelMapper<NetworkDeviceDto, NetworkDevice> converter) {
        this.networkDeviceRepository = networkDeviceRepository;
        this.converter = converter;
    }

    @Override
    public List<NetworkDeviceDto> findAll() {
        return networkDeviceRepository.findAll()
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

}
