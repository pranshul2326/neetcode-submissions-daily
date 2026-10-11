class Node{
    int time;
    String value;
    public Node(String value,int time){
        this.value = value;
        this.time = time;
    }
}
class TimeMap {

    HashMap<String,ArrayList<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Node node = new Node(value,timestamp);
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<Node>());
            
        }
        map.get(key).add(node);
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Node> list = map.get(key);
        int n = list.size();
        int i = 0;
        int j = n-1;
        while(i<=j){
            int mid = i + (j-i)/2;
            Node mid_value = list.get(mid);
            if(mid_value.time == timestamp){
                return mid_value.value;
            }
            if(mid_value.time>timestamp){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        System.out.print(i+" "+list);
        return j >= 0 ? list.get(j).value : "";

        
    }
}
