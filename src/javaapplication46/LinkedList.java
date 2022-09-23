/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication46;

import java.util.Random;

/**
 *
 * @author LAND
 */
public class LinkedList<T extends Integer> {
    private Node root;
    private int count;
    private class Node{
        private Node next;
        private T data;
        public Node(){
            
        }
        public Node(T data){
            this.data=data;
        }      
    }
    public LinkedList(){
        root=new Node();  
        count=0;
    }
    /**
     * 新增卡牌
     * @param data 
     */
    public void add(T data){
        Node tmp=root;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=new Node(data);
        count++;
    }
    /**
     * 將index位置的值改為data
     * @param index 位置
     * @param data 新的值
     */
    public void set(int index,T data){
        if(index<0||index>=count){
            return;
        }
        Node tmp=root;
        for(int i=0;i<index;i++){
            tmp=tmp.next;
        }
        tmp.next.data=data;
    }
    /**
     * 取得特定位置的卡牌
     * @param index
     * @return 
     */
    public T get(int index){
        if(index<0||index>=count){
            return null;
        }
        Node tmp=root;
        for(int i=0;i<index;i++){
            tmp=tmp.next;            
        }
        return tmp.next.data;
    }
}
