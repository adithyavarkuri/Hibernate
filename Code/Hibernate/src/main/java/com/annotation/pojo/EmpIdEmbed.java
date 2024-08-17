package com.annotation.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class EmpIdEmbed implements Serializable{
	
	    @Column(name = "id")
	    private Integer id;
	    
	    @Column(name = "id1")
	    private Integer id1;
		
	    public EmpIdEmbed(int id, int id1) {
	    	this.id=id;
	    	this.id1 =id1;
	    }
	    public EmpIdEmbed(){
	    	
	    }
	    
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getId1() {
			return id1;
		}
		public void setId1(Integer id1) {
			this.id1 = id1;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((id1 == null) ? 0 : id1.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EmpIdEmbed other = (EmpIdEmbed) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (id1 == null) {
				if (other.id1 != null)
					return false;
			} else if (!id1.equals(other.id1))
				return false;
			return true;
		}
	    
		

}
