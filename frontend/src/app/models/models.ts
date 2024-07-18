export interface LoginRequest {
    username : string,
    password : string
}

export interface EmployeeRead {
    employeeId : string,
    firstName : string,
    lastName : string,
    nic : string,
    dob : Date
    profilePicture : string,
    hiredDate : Date,
    address : string,
    email : string,
    gender : string,
    branchName : string,
    jobRoleTitle : string,
    account: {
        username: string,
        password: string,
        isManager: boolean
    }
}

export interface EmployeeCreate {
    employeeId : string,
    firstName : string,
    lastName : string,
    nic : string,
    dob : string
    profilePicture : string,
    hiredDate : string,
    address : string,
    email : string,
    gender : string,
    branchName : string,
    jobRoleTitle : string,
    account: {
        username: string,
        password: string,
        isManager: boolean
    }
}

export interface Branch{
    name:string,
    latitude:Number,
    longitude:Number,
    address:string
}