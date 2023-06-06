package com.example.taskapp.Tasks.Domain.Utility

sealed class TaskOrder (val orderType: OrderType){
    class Date(orderType: OrderType): TaskOrder(orderType)
}
