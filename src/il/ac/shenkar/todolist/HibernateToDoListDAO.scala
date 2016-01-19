package il.ac.shenkar.todolist

import java.util._
import org.hibernate._
import org.hibernate.cfg._
import org.hibernate.Criteria._
import org.hibernate.criterion.Restrictions
import org.hibernate.criterion.Projection
import scala.collection.JavaConversions._


class HibernateToDoListDAO extends IToDoListDAO {
  
  var factory: SessionFactory = _
  var session: Session = _
  
  @throws(classOf[ToDoListException])
  def updateItem(item: Item) {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    try {
      session.beginTransaction()
      session.saveOrUpdate(item)
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: UpdateItem")
    } finally {
      session.close()
    }
  }
  
  @throws(classOf[ToDoListException])
  def updateUser(user: User) {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    try {
      session.beginTransaction()
      session.saveOrUpdate(user)
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: UpdateUser")
    } finally {
      session.close()
    }  
  }
  
	@throws(classOf[ToDoListException])
  def deleteItem(item: Item) {
	  factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    try {
      session.beginTransaction()
      session.delete(item)
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: DeleteItem")
    } finally {
      session.close()
    }  
	}
	
	@throws(classOf[ToDoListException])
	def deleteUser(userId: Int) {
	  factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    val user = session.get(classOf[User], userId).asInstanceOf[User]
    try {
      session.beginTransaction()
      session.delete(user)
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: DeleteUser")
    } finally {
      session.close()
    }  
	}
	
	@throws(classOf[ToDoListException])
	def addItem(item: Item) {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    try {
      session.beginTransaction()
      session.save(item)
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: AddItem")
    } finally {
      session.close()
    }	  
	}
	
	@throws(classOf[ToDoListException])
	def addUser(user: User) {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    try {
      session.beginTransaction()
      session.save(user)
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: AddUser")
    } finally {
      session.close()
    }	  
	}
	
	@throws(classOf[ToDoListException])
	def getItem(id: Int): Item = {
    var getItem = new Item()
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    try {
      session.beginTransaction()
      getItem = session.get(classOf[Item], id).asInstanceOf[Item]
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: GetItem")
    } finally {
      session.close()
    }
    getItem	  
	}
	
	@throws(classOf[ToDoListException])
	def getUser(id: Int): User = {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    var user: User = null
    try {
      session.beginTransaction()
      user = new User()
      user = session.get(classOf[User], id).asInstanceOf[User]
      session.getTransaction.commit()
    } catch {
      case e: HibernateException => throw new ToDoListException("Hibernate: GetUser")
    } finally {
      session.close()
    }
    user	  
	}
	
	def getItemCount(userId: Int): Long = {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    val hql = "SELECT count(*) FROM Item I WHERE I.userId = :userId"
    val query = session.createQuery(hql)
    query.setParameter("userId", userId);
    val count = query.uniqueResult().asInstanceOf[Long]
    count
	}

  def getUsers(): ArrayList[User] = {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    val hql = "FROM User"
    val query = session.createQuery(hql)
    val users = query.list().asInstanceOf[ArrayList[User]]
    users
  }

  def getItems(id: Int): ArrayList[Item] = {
    factory = new Configuration().configure().buildSessionFactory()
    session = factory.openSession()
    val hql = "FROM Item I WHERE I.userId = :user_id"
    val query = session.createQuery(hql)
    query.setParameter("user_id", id)
    val items = query.list().asInstanceOf[ArrayList[Item]]
    items
  }

}

object HibernateToDoListDAO  {
  
  var DAO = new HibernateToDoListDAO()
  @throws(classOf[ToDoListException])
  def updateItem(item: Item) = DAO.updateItem(item)
  
  @throws(classOf[ToDoListException])
  def updateUser(user: User) = DAO.updateUser(user)
  
  @throws(classOf[ToDoListException])
  def deleteItem(item: Item) = DAO.deleteItem(item)
  
  @throws(classOf[ToDoListException])
  def deleteUser(userId: Int) = DAO.deleteUser(userId)
  
  @throws(classOf[ToDoListException])
  def addItem(item: Item) = DAO.addItem(item)
  
  @throws(classOf[ToDoListException])
  def addUser(user: User) = DAO.addUser(user)
  
  @throws(classOf[ToDoListException])
  def getItem(id: Int) = DAO.getItem(id)
  
  @throws(classOf[ToDoListException])
  def getUser(id: Int) = DAO.getUser(id)
  
  def getItemCount(userId: Int): Long = DAO.getItemCount(userId)
  
  def getItems(id: Int): ArrayList[Item] = DAO.getItems(id)
  
  def getUsers(): ArrayList[User] = DAO.getUsers()
  
}