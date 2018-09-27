package com.example.warehouse_kotlin.controllers

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner.class)
@WebMvcTest(value = WareHouseController.class, secure = false)
internal class WarehouseControllerTest {
    @Autowired
    mockMvc: MockMvc
}