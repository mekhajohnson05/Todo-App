import httpCommon from "./http-common";

class TaskServices{

    savetask(task){
        return httpCommon.post("/tasks",task);
    }

    viewall(){
        return httpCommon.get("/tasks");
    }

    update(id){
        return httpCommon.put("/tasks/"+id);
    }

   delete(id){
        return httpCommon.delete("/tasks/"+id);
    }
}

export default new TaskServices();