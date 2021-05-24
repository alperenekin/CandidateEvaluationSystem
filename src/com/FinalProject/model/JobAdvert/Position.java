package com.FinalProject.model.JobAdvert;

public enum Position {
        Mobile,
        Web,
        Frontend;

    public String toString(){
            switch (this){
                case Mobile:
                    return "Mobile developer";
                case Web:
                    return "Web developer";
                case  Frontend:
                    return "Frontend developer";
                default:
                    return "";
            }
    }
}
