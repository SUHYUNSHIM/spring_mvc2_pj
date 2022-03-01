package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA",10000,10);

        //when
        Item savedItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem); //저장된 값과 조회된 값이 같다.
        //Assertions.assertThat -> alt+enter : add on-demand static import
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void clearStore() {
    }
}