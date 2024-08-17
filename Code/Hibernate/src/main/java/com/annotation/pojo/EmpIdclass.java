package com.annotation.pojo;

import java.io.Serializable;

public class EmpIdclass implements Serializable{
	
	    private Integer id;
	    private Integer id1;
		
	    public EmpIdclass(int id, int id1) {
	    	this.id=id;
	    	this.id1 =id1;
	    }
	    public EmpIdclass(){
	    	
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
			EmpIdclass other = (EmpIdclass) obj;
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
