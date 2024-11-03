package com.example.study.mapstruct.car.mapper;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
