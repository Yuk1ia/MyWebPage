package  com.github.Yuk1ia.MyWebPage.repository;

import com.github.Yuk1ia.MyWebPage.entity.Link; // 重要：导入你的实体类
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LinkRepository extends JpaRepository<Link,Long>{
}