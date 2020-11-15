package ru.sbrf.cu.list;

import java.lang.ArrayIndexOutOfBoundsException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>, MyQueue<T> {
    private ListItem<T> head = null;
    private ListItem<T> tail = null;
    private int size = 0;

    @Override
    public void add( T item ) {
        // Создаем новый элемент

        ListItem<T> internalItem = new ListItem<>();
        internalItem.value = item;
        //Если голова ещё не задана - то её присваиваем новому элементу
        if ( head == null ) {
            head = internalItem;
        }
        // Хвост заменяется на новый
        ListItem<T> tempTail = tail;
        tail = internalItem;
        // Связываем старый хвост и новый хвост между собой
        if ( tempTail != null ) {
            tempTail.next = tail;
        }
        tail.prev = tempTail;
        // Двигаемся по счетчику
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get( int index ) {
        // TODO Ошибка если индекс больше размера +
        // TODO Если индекс > size/2 - то перебираем от tail
        if ( index<0 || index>=size ){
            throw new ArrayIndexOutOfBoundsException();
        }
        int currPosition = 0;
        T result = null;
        ListItem<T> item = head;
        // Пошли перебирать элементы пока не дойдем до индекса или же не выйдем за размеры списка
        if (index > size/2) {
            currPosition = size-1;
            item = tail;
            while ( result == null && currPosition < size ) {
                if ( index == currPosition ) {
                    result = item.value;
                }
                item = item.prev;
                currPosition--;
            }
        } else {
            while (result == null && currPosition < size) {
                if (index == currPosition) {
                    result = item.value;
                }
                item = item.next;
                currPosition++;
            }
        }
        return result;
    }

    @Override
    public boolean remove( T item ) {

        //Позволяет удалять элементы по значению, независимо от количества совпадений
        ListItem<T> curItem = head;
        boolean result = false;
        if (size > 0){
            ListItem<T> nextItem = null;
            ListItem<T> prevItem = null;
            while ( curItem.next != null) {
                if (curItem.value == item)
                {
                    nextItem = curItem.next;
                    if (curItem.prev != null){
                        prevItem = curItem.prev;
                    }
                    if (prevItem != null) {
                        prevItem.next = nextItem;
                    } else {
                        head = curItem.next;
                    }
                    if (nextItem.prev != null) {
                        nextItem.prev = prevItem;
                    }
                    curItem.next = null;
                    curItem.prev = null;
                    size--;
                    result = true;
                }

                // Сдвигаем элемент дальше
                if (curItem.next == null) {
                    curItem = nextItem;
                }
                else {
                    curItem = curItem.next;
                }

                // Проверяем если текущий элемент хвост, то удаляем его и теперь хвост = пред элементу
                if (curItem == tail && curItem.value == item)
                {
                    tail = curItem.prev;
                    size--;
                }
            }
        }

        return result;
    }

    @Override
    public T poll() {
        //Возвращаем первый элемент
        T result = null;
        ListItem<T> first = head;
        if (size > 0){
            result = first.value;
            head = first.next;
            first.next = null;
            first.prev = null;
            size--;
        }
        return result;
    }

    @Override
    public void sort() {
        //Поправил сортировку, теперь работает
        ListItem<T> first;
        ListItem<T> second;
        T tempVal;
        for(first = head; first.next != null; first = first.next) {
            for(second = first.next; second != null; second = second.next) {
                if(second.value.compareTo( first.value ) < 0) {
                    tempVal = first.value;
                    first.value = second.value;
                    second.value = tempVal ;
                }
            }
        }
    }

    private class ListItem<T> {
        T value;
        ListItem<T> prev;
        ListItem<T> next;
    }
}