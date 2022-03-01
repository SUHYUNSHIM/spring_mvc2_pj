package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long,Item> store = new HashMap<>(); //동시에 여러 스레드 접근 시, HashMap을 쓰면 안됨.
    //ConcurrentHashMap<>();을 사용해야 한다.
    private static long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values()); //arraylist에 값을 넣어도 실제 store에는 변화가 없다.
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId); //update 하려면 일단 찾아온다. 검색
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore(){
        store.clear();
    }
}
