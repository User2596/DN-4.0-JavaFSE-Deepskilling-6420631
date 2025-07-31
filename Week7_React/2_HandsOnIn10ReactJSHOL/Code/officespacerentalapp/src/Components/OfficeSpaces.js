import sr from '../officespace.jpg';

const office = {
    Name: 'DBS',
    Rent: 50000,
    Address: 'Chennai'
};

export const officeList = [
    office,
    { Name: 'Zenith', Rent: 70000, Address: 'Mumbai' },
    { Name: 'Solace', Rent: 60000, Address: 'Kolkata' },
    { Name: 'RFN', Rent: 65000, Address: 'Delhi' }
];

export const OfficeSpaceRentalApp = ({ offices }) => {
    const element = "Office Space"
    const jsxatt = <img src={sr} width='25%' height='25%' alt={element} />
    return (
        <div style={{ marginLeft: '10vw' }}>
            <h1>{element}, at Affordable Range </h1>
            {jsxatt}
            {
                offices.map((item, index) => {
                    let color = [];
                    if (item.Rent <= 60000) {
                        color.push('red');
                    } else {
                        color.push('green');
                    }

                    return (
                        <div key={index}>
                            <h1> Name: {item.Name} </h1>
                            <h3 style={{ color }}> Rent: {item.Rent} </h3>
                            <h3> Address: {item.Address} </h3>
                            <hr />
                        </div>
                    )
                })
            }
        </div >
    )
}